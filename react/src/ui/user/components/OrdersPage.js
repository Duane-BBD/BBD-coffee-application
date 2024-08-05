import React, { useState } from 'react';
import '../static/OrderPage.css';

const OrderPage = () => {
    const [cappuccinoCount, setCappuccinoCount] = useState(1);
    const [latteCount, setLatteCount] = useState(1);

    const increaseCount = (setter, count) => {
        setter(count + 1);
    };

    const decreaseCount = (setter, count) => {
        if (count > 1) {
        setter(count - 1);
        }
    };

  return (
    <div className="order-page">
        <div className="header">
            <div className="header-item active">Place an order</div>
            <div className="header-item">My orders</div>
        </div>
        
        <div className="order-item">
            <img src="path/to/cappuccino-image.png" alt="Cappuccino" className="item-image" />
            <div className="item-details">
            <div className="item-name">Cappuccino</div>
            <div className="item-note">If there was a note made it will sit over here and can run over many lines.</div>
            </div>
            <div className="item-counter">
            <button onClick={() => decreaseCount(setCappuccinoCount, cappuccinoCount)}>-</button>
            <span>{cappuccinoCount}</span>
            <button onClick={() => increaseCount(setCappuccinoCount, cappuccinoCount)}>+</button>
            </div>
        </div>
        
        <div className="order-item">
            <img src="path/to/latte-image.png" alt="Latte" className="item-image" />
            <div className="item-details">
            <div className="item-name">Latte</div>
            </div>
            <div className="item-counter">
            <button onClick={() => decreaseCount(setLatteCount, latteCount)}>-</button>
            <span>{latteCount}</span>
            <button onClick={() => increaseCount(setLatteCount, latteCount)}>+</button>
            </div>
        </div>
        
        <button className="place-order">Place order</button>
        
        <div className="footer">
            <div className="footer-icon home-icon"></div>
            <div className="footer-icon order-icon active"></div>
        </div>
    </div>
  );
};

export default OrderPage;
