import React, { useState } from 'react'
import styles from './Todo.module.css'
import GarbageIcon from "../../../public/static/svg/garbage.svg"

const Todo = (props) => {
    // todo 완료 체크 여부, check state
    const [isCompleted,setIsCompleted] = useState(false);
    // todo 완료 체크 값 변경 핸들러 함수
    const checkHandler = () => {
        setIsCompleted(!isCompleted);
        console.log(isCompleted);
    }
  return (
    <li className={styles.todo}>
        <input className={styles.toggle} type="checkbox" checked={isCompleted} onChange={checkHandler}/>
        <label className={`${styles['todo-title']} ${isCompleted && styles['todo-is-completed']}`}>{props.id} - {props.title}</label>
        <GarbageIcon className={styles.delete}oiiool
        
        />
    </li>
  )
}

export default Todo