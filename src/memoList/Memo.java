package memoList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 메모 한 건에 대한 정보를 가진 클래스
public class Memo {
    private int memoNumber; // 글 번호
    private String writerName; // 작성자명
    private String password; // 비밀번호
    private String writedMemo; // 글 내용 // 한지훈 : 제가 기억하기 편한 변수명으로 수정했습니다.
    private String writedTime; // 작성일 (컴퓨터 시스템의 날짜, 시간을 자동으로 저장)

    // getter/setter는 완성 후 사용하지 않는 것을 지워주세요


    public int getMemoNumber() {
        return memoNumber;
    }

    public void setMemoNumber(int memoNumber) {
        this.memoNumber = memoNumber;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWritedMemo() {
        return writedMemo;
    }

    public void setWritedMemo(String writedMemo) {
        this.writedMemo = writedMemo;
    }

    public String getWritedTime() {
        return writedTime;
    }

    public void setWritedTime(String writedTime) {
        this.writedTime = writedTime;
    }

    // 리스트에 입력할 때 변수를 받는 생성자 메서드
    public Memo(int memoNumber, String writerName, String password, String writedMemo, String writedTime) {
        this.memoNumber = memoNumber;
        this.writerName = writerName;
        this.writedTime = writedTime;
        this.password = password;
        this.writedMemo = writedMemo;
    }

    public String toString(int memoNumber, String writerName, String writedMemo, String writedTime) { // 비밀번호는 출력 X
        return String.format("%d.  %s \t: %s \t\t %s",memoNumber, writerName, writedMemo, writedTime); // 1.  한지훈   : 안녕하세요         2023/06/03 14:56:27
    }

    /*
     * 생성 시 현재 시간을 저장하도록 해둠
     * 입력 시 저장하는 것으로 변경하고 싶으시면 아래 코드 복사해서 입력 시 값 넣어주세요!
     */

    public void editWtritedTime(){ // 기본 생성자는 변수들을 입력받는데 사용하고 싶어 메서드명을 수정했습니다.
        LocalDateTime now = LocalDateTime.now();  // 현재 시간
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // 포맷 정의 포맷은 연/월/일 시간:분:초 >> 변경 가능
        //ex) 2023/06/03 13:42:10
        this.writedTime = now.format(formatter); // 포맷 적용, 변수 저장
        System.out.println(writedTime); //테스트용 출력 / 추후 삭제 해주세요
    }
}
