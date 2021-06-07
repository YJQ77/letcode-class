package com.example.demo.util.clazz;

import java.util.Map;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

/**
 * 描述：对象操作工具类
 * @author jiangwenyu
 * @date 2020年11月4日
 */
public class DynamicBean {
	
	private Object target;
    private BeanMap beanMap;

	public DynamicBean(Class<?> superclass, Map<String, Class<?>> propertyMap) {
		this.target = generateBean(superclass, propertyMap);
		this.beanMap = BeanMap.create(this.target);
	}

	public void setValue(String property, Object value) {
		beanMap.put(property, value);
	}

	public Object getValue(String property) {
		return beanMap.get(property);
	}

	public Object getTarget() {
		return this.target;
	}

	/**
	 * 根据属性生成对象
	 * 
	 * @param superclass
	 * @param propertyMap
	 * @return
	 */
	private Object generateBean(Class<?> superclass, Map<String, Class<?>> propertyMap) {
		BeanGenerator generator = new BeanGenerator();
		if (null != superclass) {
			generator.setSuperclass(superclass);
		}
		BeanGenerator.addProperties(generator, propertyMap);
		return generator.create();
	}

}
