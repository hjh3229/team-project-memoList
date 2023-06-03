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

    public void setMemos(ArrayList<Memo> memos) {
        this.memos = memos;
    }

    private int saveMemoNumber(int selectNumber) { // 수정/삭제할 때 선택한 메모를 초기화 하기 전에 미리 해당 메모의 번호를 저장해두는 메서드
        int saveMemoNumber = selectNumber;
        return saveMemoNumber;
    }

    // 메모 전체 출력하기
    public void printMemos() {
        while (true) {
            for (Memo memo : getMemos()) {
                System.out.println(memo.toString(memo.getMemoNumber(), memo.getWriterName(), memo.getWritedMemo(), memo.getWritedTime()));
            }
            System.out.println("\n------------------------------------------------\n");
            System.out.println("1. 메모 추가     2. 메모 수정      3. 메모 삭제");

            Scanner sc = new Scanner(System.in);
            int check = sc.nextInt(); // 아래에서 메모 작업을 수행할 때 받을 번호 입력
            switch (check) {
                case 1 :
                    // 메모 추가 메서드
                    break;
                case 2 :
                    // 메모 수정 메서드
                    break;
                case 3 :
                    // 메모 삭제 메서드
                case 0 :
                    return; // 메모 창 작업 닫기
                default:
                    System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
            }
        }
    }
}
