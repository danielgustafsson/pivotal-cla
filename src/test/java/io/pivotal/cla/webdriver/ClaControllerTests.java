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
package io.pivotal.cla.webdriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import io.pivotal.cla.data.ContributorLicenseAgreeement;
import io.pivotal.cla.security.WithSigningUser;
import io.pivotal.cla.webdriver.pages.SignClaPage;

@WithSigningUser
public class ClaControllerTests extends BaseWebDriverTests {

	private ContributorLicenseAgreeement agreement;

	@Before
	public void agreement() {
		agreement = new ContributorLicenseAgreeement();
		agreement.setName("apache");
		agreement.setCorporateContent("Corp");
		agreement.setIndividualContent("Individual");
		agreement.setId(1L);
		agreement.setCreated(new Date());
	}

	@Test
	public void view() {
		when(mockClaRepository.findByName(agreement.getName())).thenReturn(agreement);

		SignClaPage signPage = SignClaPage.go(getDriver(), agreement.getName());

		assertThat(signPage.getIndividualCla()).isEqualTo(agreement.getIndividualContent());
	}

	@Test
	public void sign() {

		when(mockClaRepository.findByName(agreement.getName())).thenReturn(agreement);

		SignClaPage signPage = SignClaPage.go(getDriver(), agreement.getName());

		assertThat(signPage.getIndividualCla()).isEqualTo(agreement.getIndividualContent());
	}
}