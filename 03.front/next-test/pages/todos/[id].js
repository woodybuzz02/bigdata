import React from 'react'
import { useRouter } from 'next/router'

const TodoDetailPage = () => {
    const router = useRouter();
    console.log('pathname', router.pathname);
    console.log('query', router.query);
    console.log('quert id', router.query.id);
    console.log('asPath', router.asPath);
  return (
    <div>TodoDetailPage</div>
  )
}

export default TodoDetailPage