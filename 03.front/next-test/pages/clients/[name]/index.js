import React from 'react'
import { useRouter } from 'next/dist/client/router';

const ClientDetailPage = () => {
    const router = useRouter();
    console.log('clientDetailPage', router.query);
  return (
    <div>{router.query.name}</div>
  )
}

export default ClientDetailPage