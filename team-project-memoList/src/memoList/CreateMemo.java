package memoList;

public class ReadMemo implements MemoListManager{

    // <====================== 확인 후 채택 여부 결정 ======================> //
    MemoList readMemoList;

    public ReadMemo(MemoList memoList) {
        this.readMemoList = memoList;
    }

    @Override
    public void performAction() {
        for (Memo memo : readMemoList.getMemos()) {
            System.out.println(memo.toString(memo.getMemoNumber(), memo.getWriterName(), memo.getWritedMemo(), memo.getWritedTime()));
        }
    }
}
