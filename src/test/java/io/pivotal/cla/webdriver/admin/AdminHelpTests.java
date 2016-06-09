/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.pivotal.cla.webdriver.admin;

import org.junit.Test;

import io.pivotal.cla.security.WithAdminUser;
import io.pivotal.cla.webdriver.BaseWebDriverTests;
import io.pivotal.cla.webdriver.pages.admin.AdminHelpMigratePage;
import io.pivotal.cla.webdriver.pages.admin.AdminHelpPage;

@WithAdminUser
public class AdminHelpTests extends BaseWebDriverTests {

	@Test
	public void navigationWorks() {
		AdminHelpPage help = AdminHelpPage.to(getDriver());
		help.assertAt();

		help = help.adminHelp();
		help.assertAt();
	}

	@Test
	public void migrateAccessible() {
		AdminHelpPage help = AdminHelpPage.to(getDriver());
		help.assertAt();

		AdminHelpMigratePage migrate = help.migrate();
		migrate.assertAt();
	}
}