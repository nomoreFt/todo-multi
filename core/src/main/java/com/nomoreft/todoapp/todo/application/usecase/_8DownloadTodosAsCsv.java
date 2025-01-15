package com.nomoreft.todoapp.todo.application.usecase;


import com.nomoreft.todoapp.shared.identifier.UserId;

/**
 * 8. 할일을 CSV로 다운로드할 수 있습니다.
 */
public interface _8DownloadTodosAsCsv {
    byte[] downloadAsCsv(UserId owner);
}
