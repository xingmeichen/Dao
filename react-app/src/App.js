import { useState } from 'react';
import './App.css';
import AddList from './components/AddList';
import List from './components/List';

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
      <div>First React App</div>
      <AddList addItem={addItem} />
      <List list={list} deleteItem={deleteItem} />
    </div>
  );
}

export default App;
