import React from 'react'
import { useRouter } from 'next/dist/client/router';

const ClientPhonePage = () => {
    const router = useRouter();
    console.log('clientPhonePage', router.query);
  return (
    <div>{router.query.name} - {router.query.phone}</div>
  )
}

export default ClientPhonePage