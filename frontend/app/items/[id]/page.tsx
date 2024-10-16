"use client"

import useFetchItemById from "@/lib/hooks/useFetchItemById"

export default function ViewItem({ params }: { params: { id: number } }) {
  const { data, isLoading, error } = useFetchItemById(params.id)

  if (error) {
    // TODO add actual error handling logic
    console.log(error)
  }

  if (isLoading) {
    return (<div> loading </div>)
  }

  // Not laoding and no data, something went wrong
  // TODO: Figure out what to do when no data loads for whatever reason. Probably linked to the if (error)
  if (!data) {
    return (<div> whoopsie daisy</div>)
  }

  // No need to worry about data being empty and having a bunch of ????????????????? here
  return (
    <div>
      {data.title}
      {data.description}
    </div>
  )
}