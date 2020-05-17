import com.apnatriangle.main.java.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseIT {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpEntity<String> entity = new HttpEntity<String>(null, null);

    @Test
    public void testRetrieve() {
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/hello"),
                HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    public void getCourse() {
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/course/java101"),
                HttpMethod.GET, entity, String.class);
        assertEquals("{\"code\":\"java101\",\"description\":\"Java Language Fundamentals\"}", response.getBody());
    }
}
