// Header.js에서 Header로 export된 값(함수, 변수)을 가져오겠다. 사용하겠다.
import { isClickableInput } from '@testing-library/user-event/dist/utils';
import { useState } from 'react';
import Books from './components/Books/Books';
import Cart from './components/Cart/Cart';
import Header from './components/Layout/Header';
import Main from './components/Layout/Main';

function App() {
  // cartIsShown이라는 state값으로 <Cart />컴포넌트를 조건부 렌더링 시키기.
  const [cartIsShown, setCartIsShown] = useState(false)

  // openCartHandler : 버튼 클릭시 state값을 변경하여 Modal Window를 활성화해주는 핸들러
  const openCartHandler = () => {
    setCartIsShown(true);
  }

  const closeCartHandler = () => {
    setCartIsShown(false);
  }


  return (
    <>
      {cartIsShown && <Cart onClose={closeCartHandler}/>}
      <Header onOpen={openCartHandler}/>
      <Main>
        <Books />
      </Main>
    </>
    
    
  );
}

export default App;