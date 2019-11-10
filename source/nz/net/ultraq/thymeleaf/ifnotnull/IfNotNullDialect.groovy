/* 
 * Copyright 2015, Emanuel Rabina (http://www.ultraq.net.nz/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.thymeleaf.ifnotnull

import nz.net.ultraq.thymeleaf.ifnotnull.processors.SrcProcessor
import nz.net.ultraq.thymeleaf.ifnotnull.processors.TextProcessor
import nz.net.ultraq.thymeleaf.ifnotnull.processors.UTextProcessor

import org.thymeleaf.dialect.AbstractProcessorDialect
import org.thymeleaf.processor.IProcessor
import org.thymeleaf.standard.StandardDialect
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor
import org.thymeleaf.templatemode.TemplateMode

/**
 * Dialect to add the if-not-null processors for use in Thymeleaf templates.
 * 
 * @author Emanuel Rabina
 */
class IfNotNullDialect extends AbstractProcessorDialect {

	static final String DIALECT_NAME   = 'If-Not-Null'
	static final String DIALECT_PREFIX = 'ifnotnull'

	/**
	 * Constructor, initializes this dialect.
	 */
	IfNotNullDialect() {

		super(DIALECT_NAME, DIALECT_PREFIX, StandardDialect.PROCESSOR_PRECEDENCE)
	}

	/**
	 * Returns the processors for the dialect.
	 * 
	 * @param dialectPrefix
	 * @return Set of new if-not-null processors.
	 */
	@Override
	Set<IProcessor> getProcessors(String dialectPrefix) {

		return [
			new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix),
			new SrcProcessor(TemplateMode.HTML, dialectPrefix),
			new TextProcessor(TemplateMode.HTML, dialectPrefix),
			new UTextProcessor(TemplateMode.HTML, dialectPrefix),

			new StandardXmlNsTagProcessor(TemplateMode.XML, dialectPrefix),
			new SrcProcessor(TemplateMode.XML, dialectPrefix),
			new TextProcessor(TemplateMode.XML, dialectPrefix),
			new UTextProcessor(TemplateMode.XML, dialectPrefix)
		]
	}
}
