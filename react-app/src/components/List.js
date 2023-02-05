
const List = (props) => {

    return (
        <div>
            {props.list.map((item, index) => {
                return <div>{item}<button key={index} onClick={() => props.deleteItem(index)}>Delete</button></div>
            })}
        </div>
    );
}

export default List;