package com.springstudy.define;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassPathXmlApplicationContextDefImp implements ApplicationContextDef {
    private Map<String,Object> ioc=new HashMap<String,Object>();

    public  ClassPathXmlApplicationContextDefImp(String path){
        try {
            //加载spring配置文件，使用dom4j进行解析
            SAXReader reader=new SAXReader();
            Document document=reader.read("./src/"+path);

            Element root = document.getRootElement();
            Iterator<Element> iteratorBean = root.elementIterator();
            while (iteratorBean.hasNext()){
                //遍历bean标签
                Element elementBean=iteratorBean.next();
                //获取bean标签的id
                String id=elementBean.attributeValue("id");
                //获取bean标签的class
                String className=elementBean.attributeValue("class");
                //通过反射获取到运行时类
                Class clazz=Class.forName(className);
                //获取无参构造方法
                Constructor constructor=clazz.getConstructor();
                //通过构造方法创建实例对象
                Object object=constructor.newInstance();
                Iterator<Element> iteratorProperty = elementBean.elementIterator();
                while (iteratorProperty.hasNext()){
                    //遍历property标签
                    Element elementProperty=iteratorProperty.next();
                    //获取property标签的name(实际上也就是获取对应实体类的属性名称)
                    String name=elementProperty.attributeValue("name");
                    //获取property标签的值
                    String valueStr=elementProperty.attributeValue("value");
                    //构建实体类的set方法的名称，这里要求实体类必须有set方法
                    String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    //获取实体类的属性
                    Field field=clazz.getDeclaredField(name);
                    //获取set方法
                    Method method=clazz.getDeclaredMethod(methodName,field.getType());
                    //根据成员变量的数据类型将 value 进行转换
                    Object value=null;
                    if(field.getType().getName()=="long"){
                        value = Long.parseLong(valueStr);
                    }
                    if(field.getType().getName() == "java.lang.String"){
                        value = valueStr;
                    }
                    if(field.getType().getName() == "int"){
                        value = Integer.parseInt(valueStr);
                    }
                    //执行set方法进行赋值
                    method.invoke(object,value);
                    //将对象放入到IoC容器中，在使用的时候通过id进行获取
                    ioc.put(id,object);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return ioc.get(id);
    }
}
