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

import nz.net.ultraq.thymeleaf.texts.TextProcessor
import nz.net.ultraq.thymeleaf.texts.UTextProcessor

import org.thymeleaf.dialect.AbstractDialect
import org.thymeleaf.processor.IProcessor

/**
 * Dialect to add the if-not-null processors for use in Thymeleaf templates.
 * 
 * @author Emanuel Rabina
 */
class IfNotNullDialect extends AbstractDialect {

	/**
	 * {@inheritDoc}
	 */
	@Override
	String getPrefix() {

		return 'ifnotnull'
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	Set<IProcessor> getProcessors() {

		return [
		    new TextProcessor(),
			new UTextProcessor()
		]
	}
}
