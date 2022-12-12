import React from 'react'
import PutTodo from '../../components/Todos/Todo/PutTodo'
import { useRouter } from 'next/router';

const put = () => {

  // console.log("put.js에서 props는 잘 되고 있냐?")
  const router = useRouter();
  // console.log('todo : ', router.query.todoId);

  const todoId = router.query.todoId;
  const todoTitle = router.query.todoTitle;
  const todoDescription = router.query.todoDescription;


  return (
    <PutTodo  
    todoId={todoId}
    todoTitle={todoTitle}
    todoDescription={todoDescription}
    />
  )
}

export default put