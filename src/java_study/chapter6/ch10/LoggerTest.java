package java_study.chapter6.ch10;

public class LoggerTest {
    public static void main(String[] args) {
        MyLogger logger = MyLogger.getLogger();
        logger.log("log test");
    }
//    콘솔에 표시되는 기준은 logging.properties에 설정 돼있다.변경가능
//    7월 12, 2023 9:13:18 오후 java_study.chapter6.ch10.MyLogger log
//    INFO: log test
//    7월 12, 2023 9:13:18 오후 java_study.chapter6.ch10.MyLogger log
//    WARNING: log test
//    7월 12, 2023 9:13:18 오후 java_study.chapter6.ch10.MyLogger log
//    SEVERE: log test
}
