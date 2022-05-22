// Header 영역을 담당하는 Header 컴포넌트 작성
import classes from './Header.module.css'
import HeaderCart from './HeaderCart';

// Header 컴포넌트
const Header = (props) => {
    return (
        <>
            <header className={classes.header}>
                <h1>Book Order App</h1>
                <HeaderCart onOpen={props.onOpen}/>
            </header>
        </>
    )
};

export default Header;