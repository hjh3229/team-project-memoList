package memoList;

import java.util.Scanner;

public class Input implements MemoListManager{
    private MemoList memoList;

    public Input(MemoList memoList) {
        this.memoList = memoList;
    }

    @Override
    public void performAction() {  //사용자로부터 이름, 비밀번호, 메모를 입력받는다.
        Scanner scanner = new Scanner(System.in);        //Scanner를 사용하여 키보드 입력

        System.out.println("너의 이름은?:");
        String writerName = scanner.nextLine();

        System.out.println("비밀번호를 입력해주세요.:");
        String password = scanner.nextLine();

        System.out.println("메모메모!:");
        String writedMemo = scanner.nextLine();

        int memoNumber = memoList.getMemos().size() + 1;   //새로운 메모 번호설정, MemoList 클래스의 메모 리스트를 반환하며, size는 현제 메모 리스트의 크기를 반환한다.
        //여기에 1을 더함으로 새로운 메모의 번호를 결정한다.

        Memo newMemo = new Memo(memoNumber, writerName, password, writedMemo, "");
        newMemo.editWtritedTime();  //memo 클래스 생성자 호출하여 새로운 메모 객체를 생성한다. 이때 메모 번호,작성자 이름, 메모내용을 전달한다.
        // 작성시간은 빈 문자열로 초기화되고 'editWtritedTime' 메서드를 호출해서 현재 시간으로 설정한다.

        memoList.addMemo(newMemo);  // 생성된 메모 객체를 MemoList의 메모 리스트에 추가한다. 이렇게 함으로써 새로운 메모가 메모 리스트에 저장된다.

        System.out.println("메모가 성공적으로 저장되었습니다.!");
    }
}
