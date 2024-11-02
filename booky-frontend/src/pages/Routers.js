import AppsBar from '../components/AppsBar.js'
import AddBook from '../components/AddBook.js';
import MainBook from './/MainBook.js';
import ReadingList from './/ReadingList';


import { BrowserRouter, Route, Routes } from 'react-router-dom';

function Routers() {
  return (
    <div>
    <AppsBar/>
 <BrowserRouter>
        <Routes>

            <Route path="/" element={<AddBook />} />
            <Route path="/MainPage" element={<MainBook />} />
          <Route path="/RaedinPage" element={<ReadingList />} />
        </Routes>
      </BrowserRouter>
    </div>
  )
}





export default Routers