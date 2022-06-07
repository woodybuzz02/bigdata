import React from 'react'
import { putTodoAPI } from '../../../lib/api/todo';
import { useRouter } from 'next/router'

const updateTodo = () => {

    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [dueDate, setDueDate] = useState('');

    const router = useRouter();

    const titleChangeHandler = (event) => {
        setTitle(event.target.value);
        };
    
        const descChangeHandler = (event) => {
        setDescription(event.target.value);
        }
    
        const dateChangeHandler = (event) => {
        setDueDate(event.target.value);
        }

        const updateTodo = () => {
            const data = {
                title: title,
                description: description,
                date: dueDate,
            }
            console.log(data);
            // Post API 요청 전송
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
          <button type="button" onClick={updateTodo}>추가하기</button>
        </div>
      )
}


export default updateTodo