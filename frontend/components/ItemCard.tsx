import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardImage, CardImageContainer, CardTitle } from "./shadcn/card";
import { StoreItemData } from "@/lib/types/StoreItemTypes";
import { useState } from "react";
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "./shadcn/carousel";
import { Button } from "./shadcn/button";
import Link from "next/link";
import { formatPrice } from "@/lib/utils";

export default function ItemCard({ data }: { data: StoreItemData }) {
  return (
    <Card className="w-[400px]">
      <CardImageContainer>
        <CardImage
          src={data.thumbnailImageLink}
          className={`w-[400px] h-[200px] object-contain`}
        />
      </CardImageContainer>
      <CardHeader>
        <CardTitle>{data.title}</CardTitle>
        <CardDescription>{data.description}</CardDescription>
      </CardHeader>
      <CardFooter className="flex justify-between">
        <CardContent className="p-4">
          {
            // TODO: Make backend return formatted price
            data.discountPrice ?
            <p className="flex gap-2 items-end">
              {formatPrice(data.discountPrice)}
              <p className="line-through text-gray-500 text-sm">
                {formatPrice(data.price)}
              </p>
            </p> 
            :
            <p>{formatPrice(data.price)}</p>
          }
        </CardContent>
        <Link href={`/items/${data.id}`}>
          <Button> View More </Button>
        </Link>
      </CardFooter>
    </Card>
  );
}
