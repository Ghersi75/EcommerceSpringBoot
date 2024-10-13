import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardImage, CardImageContainer, CardTitle } from "./shadcn/card";
import { Data } from "@/app/page";
import { useState } from "react";

export default function ItemCard({ data }: { data: Data }) {
  const [images, setImages] = useState([
    "https://i.pinimg.com/236x/b2/09/c0/b209c05e517088a17d16f5401b6a616f.jpg",
    "https://prd.cc.duluthtrading.com/on/demandware.static/-/Sites-dtc-master-catalog/default/dw13c50eee/images/large/76020_EBR.jpg",
    "https://img.freepik.com/free-psd/stylish-blue-plaid-shirt-men-isolated-transparent-background_191095-23042.jpg"
  ]);

  const [imageIndex, setImageIndex] = useState(0);
  const [isFading, setIsFading] = useState(false); // State to track fade animation

  const handleLeftImageScroll = () => {
    setIsFading(true);
    setTimeout(() => {
      setImageIndex((prev) => (prev <= 0 ? images.length - 1 : prev - 1));
      setIsFading(false);
    }, 300); // Duration matches the CSS transition duration
  };

  const handleRightImageScroll = () => {
    setIsFading(true);
    setTimeout(() => {
      setImageIndex((prev) => (prev >= images.length - 1 ? 0 : prev + 1));
      setIsFading(false);
    }, 300); // Duration matches the CSS transition duration
  };

  return (
    <Card className="w-[400px]">
      <CardImageContainer>
        <CardImage
          src={images[imageIndex]}
          className={`w-[400px] h-[200px] object-contain transition-opacity duration-300 ease-in-out ${isFading ? "opacity-0" : "opacity-100"}`} 
        />
        <p>{imageIndex}</p>
        {
          // TODO: Add logic to only show arrows if there is more than 1 picture, otherwise dont
        }
        <div
          className="absolute top-1/2 transform -translate-y-1/2 left-[8px] bg-black w-[20px] h-[20px] rounded-full cursor-pointer"
          onClick={handleLeftImageScroll}
        />
        <div
          className="absolute top-1/2 transform -translate-y-1/2 right-[8px] bg-black w-[20px] h-[20px] rounded-full cursor-pointer"
          onClick={handleRightImageScroll}
        />
      </CardImageContainer>
      <CardHeader>
        <CardTitle>{data.title}</CardTitle>
        <CardDescription>{data.description}</CardDescription>
      </CardHeader>
      <CardFooter>
        <p>Buy Now</p>
      </CardFooter>
    </Card>
  );
}
