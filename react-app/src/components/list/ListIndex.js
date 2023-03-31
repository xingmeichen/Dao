import { useState } from 'react';
import AddList from "./AddList";
import List from "./List";
import NumberList from './NumberList';

const ListIndex = () => {

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

  const numbers = [1,2,3,4,5];

  return (
    <div>
      <AddList addItem={addItem} />
      <List list={list} deleteItem={deleteItem} />
      <NumberList numbers={numbers} />
    </div>
  );
}

export default ListIndex;