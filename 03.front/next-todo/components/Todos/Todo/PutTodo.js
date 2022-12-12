import React, { useState } from 'react'
import { putTodoAPI } from '../../../lib/api/todo';
import { useRouter } from 'next/router'

const PutTodo = (props) => {
    console.log("puttodo.js props... 잘들어오냐?")
    console.log(props);

    // todo입력 폼에 들어갈 항목들을 state로 관리
    const [id, setId] = useState(props.todoId);
    const [title, setTitle] = useState(props.todoTitle);
    const [description, setDescription] = useState(props.todoDescription);
    const [dueDate, setDueDate] = useState('');

    const router = useRouter();

    // 각각의 handler 함수 작성
    const titleChangeHandler = (event) => {
    setTitle(event.target.value);
    };

    const descChangeHandler = (event) => {
    setDescription(event.target.value);
    }

    const dateChangeHandler = (event) => {
    setDueDate(event.target.value);
    }

    // addTodo 함수 작성
    const putTodo = () => {
        const data = {
            id : id,
            title: title,
            description: description,
            date: dueDate,
        }
        console.log(data);

        putTodoAPI(data);

        router.replace('/');

        // 폼에 입력된 상태값 초기화
        // setTitle('');
        // setDescription('');
        // setDueDate('');
    }

  return (
    <div>
      <label htmlFor="title">할 일 제목</label>
      <input type="text" id="title" value={title} onChange={titleChangeHandler}/><br/>
      <label htmlFor="description">할 일 내용</label>
      <input type="text" id="description" value={description} onChange={descChangeHandler}/><br/>
      <label htmlFor="due-date">마감 기한</label>
      <input type="date" id="due-date" value={dueDate} onChange={dateChangeHandler}/><br/>
      <button type="button" onClick={putTodo}>수정하기</button>
    </div>
  )
}

export default PutTodo