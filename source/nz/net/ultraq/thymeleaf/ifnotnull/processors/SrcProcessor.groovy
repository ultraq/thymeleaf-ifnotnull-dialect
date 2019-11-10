/*
 * Copyright 2019, Emanuel Rabina (http://www.ultraq.net.nz/)
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

package nz.net.ultraq.thymeleaf.ifnotnull.processors

import nz.net.ultraq.thymeleaf.expressions.ExpressionProcessor

import org.thymeleaf.context.ITemplateContext
import org.thymeleaf.engine.AttributeName
import org.thymeleaf.model.IProcessableElementTag
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor
import org.thymeleaf.processor.element.IElementTagStructureHandler
import org.thymeleaf.standard.processor.StandardSrcTagProcessor
import org.thymeleaf.templatemode.TemplateMode
import org.unbescape.html.HtmlEscape

/**
 * Attribute processor for {@code ifnotnull:src}, rendering the current element
 * and setting the value of the {@code src} attribute if the expression given
 * is not null.
 * 
 * @author Emanuel Rabina
 */
class SrcProcessor extends AbstractAttributeTagProcessor {

	static final String NAME = 'src'

	/**
	 * Constructor, set this processor to work on the {@code ifnotnull:src}
	 * attribute.
	 * 
	 * @param templateMode
	 * @param dialectPrefix
	 */
	SrcProcessor(TemplateMode templateMode, String dialectPrefix) {

		super(templateMode, dialectPrefix, null, false, NAME, true, StandardSrcTagProcessor.PRECEDENCE + 1, true)
	}

	/**
	 * Evaluate the expression given to this processor, outputting the value to
	 * the src attribute if not null.  Otherwise, the element is removed.
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

		def result = new ExpressionProcessor(context).process(attributeValue)
		if (result) {
			structureHandler.setAttribute(NAME, HtmlEscape.escapeHtml5Xml(result.toString()))
		}
		else {
			structureHandler.removeElement()
		}
	}
}
