import { useState } from 'react';
import './App.css';
import AddList from './components/AddList';
import List from './components/List';
import Clock from './components/clock/Clock'

const App = () => {

  const [list, addList] = useState([]);

  const addItem = (newItem) => {
    addList([...list, newItem]);
  }

  const deleteItem = (deleteIndex) => {
    const newList = list.filter((_, index) => {
      return index !== deleteIndex;
    })
    addList(newList);
  }

  return (
    <div className="App">
      <div>Welcome To React Pratice</div>
      <Clock />
      <AddList addItem={addItem} />
      <List list={list} deleteItem={deleteItem} />
    </div>
  );
}

export default App;
