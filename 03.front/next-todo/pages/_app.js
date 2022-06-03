import Header from '../components/Layout/Header/Header'
import '../styles/globals.css'


// 모든 페이지에 공통으로 적용되는 레이아웃
function MyApp({ Component, pageProps }) {
  return (
    <div className='todoapp'>
      <Header />
      <Component {...pageProps} />
    </div>
  )
  
}

export default MyApp
