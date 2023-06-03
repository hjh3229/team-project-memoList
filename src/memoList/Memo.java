package memoList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 메모 한 건에 대한 정보를 가진 클래스
public class Memo {
    int memoNumber; // 글 번호
    String writerName; // 작성자명
    String password; // 비밀번호
    String writedMenu; // 글 내용
    String writedTime; // 작성일 (컴퓨터 시스템의 날짜, 시간을 자동으로 저장)

    /*
     * 생성 시 현재 시간을 저장하도록 해둠
     * 입력 시 저장하는 것으로 변경하고 싶으시면 아래 코드 복사해서 입력 시 값 넣어주세요!
     */

    Memo(){
        LocalDateTime now = LocalDateTime.now();  // 현재 시간
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // 포맷 정의 포맷은 연/월/일 시간:분:초 >> 변경 가능
        //ex) 2023/06/03 13:42:10
        this.writedTime = now.format(formatter); // 포맷 적용, 변수 저장
        System.out.println(writedTime); //테스트용 출력 / 추후 삭제 해주세요
    }
}
