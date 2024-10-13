import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardImage, CardImageContainer, CardTitle } from "./shadcn/card";
import { Data } from "@/app/page";
import { useState } from "react";
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "./shadcn/carousel";

export default function ItemCard({ data }: { data: Data }) {
  const [images, setImages] = useState([
    "https://i.pinimg.com/236x/b2/09/c0/b209c05e517088a17d16f5401b6a616f.jpg",
    "https://prd.cc.duluthtrading.com/on/demandware.static/-/Sites-dtc-master-catalog/default/dw13c50eee/images/large/76020_EBR.jpg",
    "https://img.freepik.com/free-psd/stylish-blue-plaid-shirt-men-isolated-transparent-background_191095-23042.jpg"
  ]);

  return (
    <Card className="w-[400px]">
      <CardImageContainer>
        <Carousel className="relative">
          <CarouselContent>
            {images.map((item, idx) => {
              return (
                <CarouselItem key={idx}>
                  <CardImage
                    src={item}
                    className={`w-[400px] h-[200px] object-contain`} 
                  />
                </CarouselItem>
              )
            })}
          </CarouselContent>
          <CarouselPrevious className="absolute left-4"/>
          <CarouselNext className="absolute right-4" />
        </Carousel>
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
