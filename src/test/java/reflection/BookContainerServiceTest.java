package reflection;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.Start;
import spring.di.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Start.class)
public class BookContainerServiceTest {

    @Test
    public void test(){
        Assertions.assertThat(3).isEqualTo(1+2);
    }

    @Autowired
    BookService bookService;

    @Test
    public void testDi() {
        Assertions.assertThat(bookService.bookRepository).isNotNull();
        Assert.assertNotNull(bookService.bookRepository);
    }
}