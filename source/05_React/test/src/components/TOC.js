const TOC = props => {
    let lists = [];
    let data = props.data;
    for(let idx=0 ; idx<data.length ; idx++) {
        lists.push(
            <li key={data[idx].id}>
                <a href={data[idx].id+'.html'}
                    data-id={data[idx].id}
                    id={data[idx].id}
                    onClick={ event => {
                        event.preventDefault();
                        props.onChangeMode(Number(event.target.id));
                    }}>
                    {data[idx].title}
                </a>
            </li>
        );
    }
    return (
        <nav>
            <ol>
                {lists}
            </ol>
        </nav>
    );
};
export default TOC;