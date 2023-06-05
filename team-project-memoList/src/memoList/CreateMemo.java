package memoList;

import java.util.ArrayList;

public class CreateMemo implements  MemoListManager{
    // <====================== 확인 후 채택 여부 결정 ======================> //
    // <====================== 이 부분은 임시로 작성함 ======================> //
    MemoList createMemolist;

    public CreateMemo(MemoList memoList) {
        this.createMemolist = memoList;
    }

    @Override
    public void performAction() {
        System.out.println("메모를 추가 테스트");

        ArrayList<Memo>memos = createMemolist.getMemos();
        memos.add(new Memo(1,"오세창", "1234","안녕하세요", "06.04"));


    }
}
