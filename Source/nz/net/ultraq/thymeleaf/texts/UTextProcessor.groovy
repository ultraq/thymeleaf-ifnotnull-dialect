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

package nz.net.ultraq.thymeleaf.texts

import org.thymeleaf.context.ITemplateContext
import org.thymeleaf.engine.AttributeName
import org.thymeleaf.model.IProcessableElementTag
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor
import org.thymeleaf.processor.element.IElementTagStructureHandler
import org.thymeleaf.standard.expression.StandardExpressions
import org.thymeleaf.standard.processor.StandardUtextTagProcessor
import org.thymeleaf.templatemode.TemplateMode

/**
 * Attribute processor for 'ifnotnull:utext', outputs unescaped text if the
 * value referenced is not null.
 * 
 * @author Emanuel Rabina
 */
class UTextProcessor extends AbstractAttributeTagProcessor {

	static final String PROCESSOR_NAME = 'utext'

	/**
	 * Constructor, set this processor to work on the 'utext' attribute.
	 * 
	 * @param dialectPrefix
	 */
	UTextProcessor(String dialectPrefix) {

		super(TemplateMode.HTML, dialectPrefix, null, false, PROCESSOR_NAME, true,
			StandardUtextTagProcessor.PRECEDENCE + 1, true)
	}

	/**
	 * Evaluate the expression given to this processor, outputting it as an
	 * unescaped child text node if not null.
	 * 
	 * @param context
	 * @param tag
	 * @param attributeName
	 * @param attributeValue
	 * @param structureHandler
	 */
	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
		AttributeName attributeName, String attributeValue, IElementTagStructureHandler structureHandler) {

		def output = StandardExpressions.getExpressionParser(context.configuration)
			.parseExpression(context, attributeValue)
			.execute(context)
		if (output) {
			structureHandler.setBody(output.toString(), false)
		}
		else {
			structureHandler.removeElement()
		}
	}
}
