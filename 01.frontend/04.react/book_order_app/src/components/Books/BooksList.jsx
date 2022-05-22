import React, { useEffect, useState } from 'react'
import Card from '../Commons/Card';
import Book from './Book/Book';
import classes from './BooksList.module.css'

const BOOKS = [
    {
      id: "book1",
      name: "THE OLD MAN AND THE SEA",
      description:
        "A story of Santiago, an aging Cuban fisherman who struggles with a giant marlin far out in the Gulf Stream off the coast of Cuba",
      author: "Ernest Hemingway",
      price: 10.57,
    },
    {
      id: "book2",
      name: "THE GREAT GATSBY",
      description:
        "Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan.",
      author: "F.Scott Fitzgerald",
      price: 12.97,
    },
    {
      id: "book3",
      name: "THE LITTLE PRINCE",
      description:
        "A young prince who visits various planets in space, including Earth, and addresses themes of loneliness, friendship, love, and loss.",
      author: "Antoine de Saint-Exupery",
      price: 15.55,
    },
    {
      id: "book4",
      name: "THE MYTH OF SISYPHUS",
      description:
        'Camus introduces his philosophy of the absurd. The absurd lies in the juxtaposition between the fundamental human need to attribute meaning to life and the "unreasonable silence" of the universe in response.',
      author: "Alber Camus",
      price: 16.92,
    },
  ];

  // BOOKS의 각 객체를 console.log()를 활용해서 출력될 수 있도록 리스팅
//   BOOKS.map(book => console.log(book));

const BooksList = () => {
    const [books, setBooks] = useState([]);

    // 1. DUMMY BOOKS 확인용
    // const booksList = books.map(book => (
    //     <li key={book.id}>
    //         <h3>{book.name}</h3>
    //         <div>{book.description}</div>
    //         <div>{book.author}</div>
    //     </li>
    // ));

    // 2. 별도의 <li> 컴포넌트로 분리
    const booksList = books.map(book => (
        <Book
            key={book.id}
            name={book.name}
            description={book.description}
            price={book.price}
            author={book.author}
        /> // key, name, description, price와 같은 이름으로 props를 내려줌
    ));

    // 3. firebase(Cloud DB)를 활용하여 DUMMY DATA GET.
    // fetch('https://book-order-4923c-default-rtdb.firebaseio.com/books.json')
    // .then(respose => respose.json())
    // .then(json => console.log(json))
    useEffect(() => {
      fetch('https://book-order-4923c-default-rtdb.firebaseio.com/books.json')
      .then(respose => respose.json())
      .then(resposeData => {
        const booksData = [];

        for(const key in resposeData){
          // console.log(key); // book1
          const book = {
            id: key,
            name: resposeData[key].name,
            description: resposeData[key].description,
            price: resposeData[key].price,
            author: resposeData[key].author,
          };
          booksData.push(book);
        }

        setBooks(booksData);
      });

    }, []);




  return (
      <section className={classes.books}>
        <Card>
          <ul>{booksList}</ul>
        </Card>
      </section>
  )
}
// html요소를 자바스크립트변수라고 인식시키기위해 {} 사용 또 반대로 치환할 수 있음.
export default BooksList