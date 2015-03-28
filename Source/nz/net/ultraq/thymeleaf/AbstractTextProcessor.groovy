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

package nz.net.ultraq.thymeleaf

import org.thymeleaf.Arguments
import org.thymeleaf.dom.Element
import org.thymeleaf.dom.Node
import org.thymeleaf.processor.ProcessorResult
import org.thymeleaf.processor.attr.AbstractAttrProcessor
import org.thymeleaf.standard.expression.StandardExpressionExecutionContext
import org.thymeleaf.standard.expression.StandardExpressions

/**
 * Common code for the text processors in this package.
 * 
 * @author Emanuel Rabina
 */
abstract class AbstractTextProcessor extends AbstractAttrProcessor {

	private final StandardExpressionExecutionContext executionContext

	/**
	 * Constructor, set to process the given attribute name.
	 * 
	 * @param attributeName
	 * @param executionContext
	 */
	protected AbstractTextProcessor(String attributeName,
		StandardExpressionExecutionContext executionContext = StandardExpressionExecutionContext.NORMAL) {

		super(attributeName)
		this.executionContext = executionContext
	}

	/**
	 * Returns an implementation-specific output node for the given text result.
	 * 
	 * @param text
	 * @return Node used to hold the output text value.
	 */
	protected abstract Node outputNodeForText(String text)

	/**
	 * Evaluate the given value, outputting it as a child text node if not null.
	 *
	 * @param arguments
	 * @param element
	 * @param attributeName
	 * @return Processing result
	 */
	@Override
	protected ProcessorResult processAttribute(Arguments arguments, Element element, String attributeName) {

		def configuration = arguments.configuration
		def parser = StandardExpressions.getExpressionParser(configuration)
		def value = element.getAttributeValue(attributeName)

		def output = parser.parseExpression(configuration, arguments, value)
			.execute(configuration, arguments, executionContext)
			.toString()

		if (output != null) {
			def outputNode = outputNodeForText(output)
			outputNode.processable = false
			element.clearChildren()
			element.addChild(outputNode)
			element.removeAttribute(attributeName)
		}
		else {
			element.parent.removeChild(element)
		}

		return ProcessorResult.OK
	}
}
