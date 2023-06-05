package memoList;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteMemo implements MemoListManager{
    MemoList deleteMemoList;
    public DeleteMemo(MemoList memoList) {
        this.deleteMemoList = memoList;
    }

    @Override
    public void performAction() {
        ArrayList<Memo> deleteMemos = deleteMemoList.getMemos(); // memos 담기

        System.out.println("삭제할 글 번호를 입력해 주세요.");
        Scanner numScanner = new Scanner(System.in);
        int memoNumber = numScanner.nextInt() - 1; // 삭제할 글 번호 입력 받기
        try {
            Memo deleteMemo = deleteMemos.get(memoNumber); // 입력 받은 번호에 해당하는 글 담기

            System.out.println("비밀번호를 입력해 주세요.");
            Scanner stringScanner = new Scanner(System.in);
            // 비밀번호 일치 여부 판단
            while (true) {
                String memoPassword = stringScanner.nextLine();
                if (!deleteMemo.getPassword().equals(memoPassword)) {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                    System.out.println("다시 입력해 주세요.");
                } else {
                    deleteMemos.remove(deleteMemo);
                    System.out.println("삭제가 완료되었습니다.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("해당 글은 존재하지 않습니다.");
        }
    }
}
