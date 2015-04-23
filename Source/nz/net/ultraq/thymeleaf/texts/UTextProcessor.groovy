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

import org.thymeleaf.dom.Macro
import org.thymeleaf.dom.Node
import org.thymeleaf.standard.expression.StandardExpressionExecutionContext
import org.thymeleaf.standard.processor.attr.StandardUtextAttrProcessor

/**
 * Attribute processor for 'ifnotnull:utext', outputs unescaped text if the
 * value referenced is not null.
 * 
 * @author Emanuel Rabina
 */
class UTextProcessor extends AbstractTextProcessor {

	final int precedence = StandardUtextAttrProcessor.ATTR_PRECEDENCE + 1

	/**
	 * Constructor, set this processor to work on the 'utext' attribute.
	 */
	UTextProcessor() {

		super('utext', StandardExpressionExecutionContext.UNESCAPED_EXPRESSION)
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Node outputNodeForText(String text) {

		return new Macro(text)
	}
}
