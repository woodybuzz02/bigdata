import React, { useState } from 'react'
import styles from './Todo.module.css'
import GarbageIcon from "../../../public/static/svg/garbage.svg"
import { useRouter } from 'next/router'


const Todo = (props) => {
    const router = useRouter();

    // todo 완료 체크 여부, check state
    const [isCompleted,setIsCompleted] = useState(false);
    // todo 완료 체크 값 변경 핸들러 함수
    const checkHandler = () => {
        setIsCompleted(!isCompleted);
        console.log(isCompleted);
    }
    // Todo 삭제
    const deleteTodo = async () => {
      // console.log('deleteTodo');
      props.deleteTodo(props.id); // Todos 컴포넌트에서 props를 통해 내려받은
      //핸들러함수 호출, 인자값으로 id값 전달 -> lifting state up
    }

    // update Todo
    const updateTodo = () => {
      router.push('/todo');
    }


  return (
    <li className={styles.todo}>
        <input className={styles.toggle} type="checkbox" checked={isCompleted} onChange={checkHandler}/>
        <label className={`${styles['todo-title']} ${isCompleted && styles['todo-is-completed']}`} onClick={updateTodo}>{props.id} - {props.title}</label>
        <GarbageIcon onClick={deleteTodo} className={styles.delete}/>
    </li>
  )
}

export default Todo