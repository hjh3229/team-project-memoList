package memoList;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateMemo implements MemoListManager{

    MemoList updateMemoList;


    public UpdateMemo(MemoList memoList) {
        this.updateMemoList = memoList;

    }

    @Override
    public void performAction() {
        ArrayList<Memo> updateMemos = updateMemoList.getMemos(); // ArrayList<Memo> memos 를 가져와서 updateMemos 에 삽입
        System.out.println("수정할 메모를 선택해주세요");
        Scanner numScanner = new Scanner(System.in);
        int memoNumber = numScanner.nextInt() - 1; // 리스트의 배열위치값과 맞추기 위해 -1 연산 //  == 1번 요구 사항 충족 == //

        try {
            Memo updateMemo = updateMemos.get(memoNumber); // ArrayList<Memo> memos 를 받은 updateMemos 의 위치 지정하여 Memo updateMemo 에 삽입

            if (updateMemo.getWritedMemo() == null) {
                System.out.println("해당 메모는 비어있습니다.");
            } // 메모 번호는 존재하지만, 메모값이 null 일때 작동하는 부분인데, 굳이 필요 없다면 지워도 될 거 같습니다.
            // 메모 번호가 없을 때 작동하는 건 아래 catch 문으로 구현했습니다.

            System.out.println("비밀번호를 입력해주세요"); //  == 3번 요구 사항 충족 == //
            Scanner stringScanner = new Scanner(System.in); // while 바깥에 생성함으써, 추후 재사용 가능

            while (true) {
                String memoPassword = stringScanner.nextLine(); // while 바깥에 선언하면, 입력받을 포인터? 가 존재하지 않아 무한 루프 발생
                if (!updateMemo.getPassword().equals(memoPassword)) {
                    System.out.println("비밀번호를 잘못 입력했습니다."); //  == 4-2번 요구 사항 충족 == //
                    System.out.println("입력하신 내용을 다시 확인해주세요.");
                } else {
                    break;
                }
            }


            System.out.println("수정할 내용을 입력해주세요.");
            System.out.println("현재 내용 : " + updateMemo.getWritedMemo());
            String editMemoWrite = stringScanner.nextLine();
            updateMemo.setWritedMemo(editMemoWrite);
            updateMemo.editWtritedTime(); // 시간 수정

            System.out.println("수정을 완료하시겠습니까 ?");
            System.out.println("1. 에    2. 아니오");
            int completionUpdateMemo = numScanner.nextInt();
            switch (completionUpdateMemo){
                case 1:
                    System.out.println("수정이 완료되었습니다 !"); //  == 4-1번 요구 사항 충족 == //
                    break;
                case 2:
                    updateMemo.setWritedMemo(updateMemo.getBackupWriteMemo());
                    System.out.println("수정을 취소합니다 !");
                    break;
            }

        } catch (Exception e) {
            System.out.println("해당 글은 존재하지 않습니다.");
        } //  == 2번 요구 사항 충족 == //
        //존재하지 않는 메모 번호를 입력했을 때 실행되는 코드입니다. 프린트 출력과 함께 최초 메모장 화면으로 돌아갑니다.


        // === try - catch 로 해당 부분을 작성한 이유 === //

        // catch로 잡지 않으면 Memo editMemo = updateMemos.get(memoNumber); 선언 시점부터 에러가 발생
        // 이유 1 : get(memoNumber)로 updateMemos의 인덱스 위치를 가져오는데, 해당 인덱스 위치를 벗어나면 에러가 발생함

        // 예시
        //  [ [ 메모 1 ] , [ 메모 2 ], [ 메모 3 ], [메모 4 ] ]
        //  memoNumber에 4번 입력 => 메모 4의 정보를 가져옴 (정상)
        //  memoNumber에 5번 입력 => 에러 발생 (사이즈를 초과한 번호이기 때문)

    }

}
