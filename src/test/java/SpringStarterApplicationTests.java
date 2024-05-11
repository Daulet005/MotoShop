//import org.example.Moto;
//import org.example.SpringConfig;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
////@SpringBootTest(classes = org.example.SpringConfig.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {SpringConfig.class})
//class SpringStarterApplicationTests {
//
//    @Qualifier("carWithModelValue")
//    @Autowired
//    private Moto moto2;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void valuesWhenStart() {
//        ApplicationContext ctx = new
//                AnnotationConfigApplicationContext(SpringConfig.class);
//
//        Moto moto = ctx.getBean("carWithModelValue", Moto.class);
//
//        assertEquals("BMW2", moto.getManufacturer());
//    }
//
//    @Test
//    void valuesWhenStartNotEquals() {
//        assertNotEquals("AUDI", moto2.getManufacturer());
//    }
//}