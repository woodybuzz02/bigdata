import Head from 'next/head'
import Footer from '../components/Layout/Footer/Footer';
import Main from '../components/Layout/Main/Main';
// 초기 dummy data 테스트용
const todos = [
  { id: 1, title: '밥 먹기', description: '밥을 먹는다'},
  { id: 2, title: '물 마시기', description: '물을 마신다'},
  { id: 3, title: '운동하기', description: '운동을 한다'},
];
const Home = () => {
// export default function Home() {
  return (
    <>
      {/* Head 해당 페이지의 메타 정보 */}
      <Head>
        <title>Todo App</title>  
        <meta name="description" content="Generated by create next app"/>
        <link rel="icon" href="/favicon.ico"/>
      </Head>
      {/*  */}
      <Main todos={todos}/>
      {/* Footer */}
      <Footer />


    
    </>
  )
}

export default Home;
