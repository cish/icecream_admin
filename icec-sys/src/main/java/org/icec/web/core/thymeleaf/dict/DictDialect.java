package org.icec.web.core.thymeleaf.dict;

import java.util.LinkedHashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

/**
 * 自定义字典标签
 * 
 * @author xxjin
 *
 */
public class DictDialect extends AbstractProcessorDialect {
	private static final String NAME = "dict dialect";
	private static final String PREFIX = "dict";

	protected DictDialect() {
		super(NAME, PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		 return createStandardProcessorsSet(dialectPrefix);
	}
	
	 private static Set<IProcessor> createStandardProcessorsSet(String dialectPrefix) {
	        LinkedHashSet processors = new LinkedHashSet();
	        processors.add(new DictShowProcessor(dialectPrefix));
	        return processors;
	 }

}
