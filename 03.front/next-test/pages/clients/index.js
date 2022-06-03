import Link from 'next/link'
import React from 'react'

const ClientPage = () => {
    const clients = [
        {id:'yoo', name: 'yoojaesuk'},
        {id:'kang', name:'kanghodong'}
    ];
  return (
    <>
        <div>ClientPage</div>
        {/* 1.static way */}
        {/* <ul>
            <li><Link href="/clients/yoo">yoo</Link></li>
        </ul> */}
        {/* 2.React way */}
        {/* <ul>
            {clients.map(client => (
                <li key={client.id}>
                    <link href={`/clients/${client.id}`}>{client.name}</Link>
                </li>
            ))}
        </ul> */}
        <ul>
            {clients.map(client => (
                <li key={client.id}>
                    <Link href={{
                        pathname: '/clients/[name]',
                        query: { name: client.name }    
                    }}>{client.name}</Link>
                </li>
            ))}
        </ul>
    </>
    
  )
}

export default ClientPage