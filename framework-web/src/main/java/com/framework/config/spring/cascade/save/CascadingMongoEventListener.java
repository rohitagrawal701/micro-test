package com.framework.config.spring.cascade.save;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class CascadingMongoEventListener extends AbstractMongoEventListener<Object>{

	private static final Logger LOG = LoggerFactory.getLogger(CascadingMongoEventListener.class);

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Object> event) {
		System.out.println("onBeforeConvert");
		super.onBeforeConvert(event);
	}

	@Override
	public void onAfterConvert(AfterConvertEvent<Object> event) {
		System.out.println("onAfterConvert");
		super.onAfterConvert(event);
	}

	@Override
	public void onBeforeDelete(BeforeDeleteEvent<Object> event) {
		super.onBeforeDelete(event);
	}

	@Override
	public void onBeforeSave(BeforeSaveEvent<Object> event) {
		super.onBeforeSave(event);
		//		final Field[] fields = event.getSource().getClass().getDeclaredFields();
		//		for (final Field field : fields) {
		//			if(field.isAnnotationPresent(CascadeSave.class)) {
		//				try {
		//					field.setAccessible(true);
		//					final Object fieldValue = field.get(event.getSource());
		//					final Method setterMethod = fieldValue.getClass().getMethod("set"+event.getSource().getClass().getSimpleName(), List.class);
		//					final Method getterMethod = fieldValue.getClass().getMethod("get"+event.getSource().getClass().getSimpleName(), null);
		//					if (getterMethod.invoke(fieldValue, null) != null) {
		//						((List<Object>) getterMethod.invoke(fieldValue, null)).add(event.getSource());
		//					} else {
		//						setterMethod.invoke(fieldValue, Arrays.asList(event.getSource()));
		//					}
		//					mongoTemplate.save(fieldValue);
		//
		//				} catch (final Exception e) {
		//					LOG.error(e.getMessage());
		//				}
		//				break;
		//			}
		//		}
	}

	@Override
	public void onAfterDelete(AfterDeleteEvent<Object> event) {
		super.onAfterDelete(event);
	}

	@Override
	public void onAfterSave(AfterSaveEvent<Object> event) {
		System.out.println("onAfterSave");
		super.onAfterSave(event);
	}

}
