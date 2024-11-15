package pl.marcinzygmunt.application;


import com.graphql.spring.boot.test.GraphQLTestTemplate;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.marcinzygmunt.domain.Company;
import pl.marcinzygmunt.repository.CompanyRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanyControllerTest {


    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @MockBean
    private CompanyRepository companyRepository;

    @Test
    @SneakyThrows
    void shouldGetCompanies() {

        when(companyRepository.getAll()).thenReturn(
                List.of(
                        Company.builder().name("New Company").build(),
                        Company.builder().name("Other Company").build()
                ));
        var res = graphQLTestTemplate.postForResource("graphql/get-company-list.graphql");
        assertEquals(2, ((List<Company>) res.getRaw("data.companyList")).size());
    }

    @Test
    @SneakyThrows
    void shouldGetCompany() {

        when(companyRepository.getAll()).thenReturn(
                List.of(
                        Company.builder().name("New Company").build(),
                        Company.builder().name("Other Company").build()
                ));
        var res = graphQLTestTemplate.postForResource("graphql/get-company.graphql");
        assertEquals("New Company", res.getRaw("data.company.name"));
    }


}