import Head from 'next/head'
import Image from 'next/image'
import styles from '../styles/Home.module.css'
import Link from 'next/dist/client/link'

// localhost:3000/
// next.js에서 index.js라는 이름의 파일은 특별한 역할을 하는 페이지
export default function Home() {
  return (
    <>
    <div>localhost:3000/ 경로로 실행되는 컴포넌트</div>
    <ul>
      <li>
        <Link href="/todos">Todos</Link>
      </li>
      <li>
        <Link href="/clients">Clients</Link>
      </li>
    </ul>
    </>
  )
}
