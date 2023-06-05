package memoList;

import java.util.ArrayList;
import java.util.Scanner;

public class MemoList {
    // 입력한 순서대로 출력하기에는 ArrayList가 제일 깔끔한 것 같아 ArrayList를 활용했습니다.
    private ArrayList<Memo> memos = new ArrayList<>();

    // 메모 전체를 조회하고 입력, 수정하기 위한 필수 요구 사항 Gettr/Setter
    public ArrayList<Memo> getMemos() {
        return memos;
    }

    public void addMemo(Memo memo) {
        memos.add(memo);
    }
    
    // 작성자 : 오세창 // MemoListManager 초기화
    private MemoListManager memoListManager;

    // 메모 전체 출력하기
    public void printMemos() {
        while (true) {
            System.out.println("\n------------------------------------------------\n");
            System.out.println("1. 메모 추가     2. 메모 조회      3. 메모 수정      4. 메모 삭제      5. 종료");
            Scanner sc = new Scanner(System.in);
            int check = sc.nextInt(); // 아래에서 메모 작업을 수행할 때 받을 번호 입력
            switch (check) {
                case 1:
                    // 메모 추가 메서드
                    memoListManager = new Input(this); // CreateMemo를 인스턴스화 하고, 이를 memoListManager 변수에 할당 => 이 과정에서 this 활용
                    memoListManager.performAction();
                    break;
                case 2:
                    memoListManager = new ReadMemo(this);
                    memoListManager.performAction();
                    break;
                case 3:
                    memoListManager = new UpdateMemo(this);
                    memoListManager.performAction();
                    break;
                case 4:
                    memoListManager = new DeleteMemo(this);
                    memoListManager.performAction();
                    break;
                case 5:
                    return; // 메모 창 작업 닫기
                default:
                    System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
            }
        }
    }
}
